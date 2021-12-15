package com.example.gbmvp.domain.presenter

import com.example.gbmvp.domain.view.IItemView
import com.example.gbmvp.domain.view.UserItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UserItemView>

