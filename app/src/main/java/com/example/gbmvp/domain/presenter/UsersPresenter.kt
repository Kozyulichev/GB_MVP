package com.example.gbmvp.domain.presenter

import android.widget.Toast
import com.example.gbmvp.SampleAppliaction
import com.example.gbmvp.domain.GetUsersUseCase
import com.example.gbmvp.domain.GitHubRepository
import com.example.gbmvp.domain.model.GithubUser
import com.example.gbmvp.domain.navigator.AndroidScreens
import com.example.gbmvp.domain.view.UserItemView
import com.example.gbmvp.domain.view.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class UsersPresenter(private val repository: GitHubRepository, private val router: Router) :
    MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {

        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()
    private val getUsersUseCase = GetUsersUseCase(repository)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = {
           // router.backTo(AndroidScreens().loginScreen(usersListPresenter.users[it.pos].login))
            router.navigateTo(AndroidScreens().loginScreen(usersListPresenter.users[it.pos].login))
            val text = usersListPresenter.users[it.pos].login
            Toast.makeText(SampleAppliaction.INSTANCE.applicationContext,text,Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadData() {
        val users = getUsersUseCase.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}