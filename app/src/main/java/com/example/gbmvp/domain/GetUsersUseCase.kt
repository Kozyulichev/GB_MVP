package com.example.gbmvp.domain

import com.example.gbmvp.domain.model.GithubUser

class GetUsersUseCase(private val repository: GitHubRepository) {
    fun getUsers(): List<GithubUser> {
        return repository.getUsers()
    }
}