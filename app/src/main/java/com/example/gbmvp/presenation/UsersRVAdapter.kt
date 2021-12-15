package com.example.gbmvp.presenation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gbmvp.databinding.ItemGithubUserBinding
import com.example.gbmvp.domain.presenter.IUserListPresenter
import com.example.gbmvp.domain.view.UserItemView

class UsersRVAdapter(private val presenter: IUserListPresenter) :
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemGithubUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(private val vb: ItemGithubUserBinding) : RecyclerView.ViewHolder(vb.root),
        UserItemView {
        override var pos = -1

        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }
    }
}

