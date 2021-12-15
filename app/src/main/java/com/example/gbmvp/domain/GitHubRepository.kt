package com.example.gbmvp.domain

import com.example.gbmvp.domain.model.GithubUser

interface GitHubRepository {
    fun getUsers(): MutableList<GithubUser>
}