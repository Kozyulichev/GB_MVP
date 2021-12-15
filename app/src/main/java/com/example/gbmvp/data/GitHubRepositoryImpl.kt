package com.example.gbmvp.data

import com.example.gbmvp.domain.GitHubRepository
import com.example.gbmvp.domain.model.GithubUser

class GitHubRepositoryImpl : GitHubRepository {

    private val githubUsersList = mutableListOf<GithubUser>()

    init {
        for (i in 0 until 10) {
            val user = GithubUser("name $i")
            githubUsersList.add(user)
        }
    }

    override fun getUsers(): MutableList<GithubUser> {
        return githubUsersList
    }
}