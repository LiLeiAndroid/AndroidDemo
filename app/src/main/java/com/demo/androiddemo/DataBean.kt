package com.demo.androiddemo

/**
 * @author FrankWang
 * @time 2020/8/26 6:17 PM
 */
data class DataBean(
    var current_user_url: String?,
    var current_user_authorizations_html_url: String?,
    var authorizations_url: String?,
    var code_search_url: String?,
    var commit_search_url: String?,
    var emails_url: String?,
    var emojis_url: String?,
    var events_url: String?,
    var feeds_url: String?,
    var followers_url: String?,
    var following_url: String?,
    var gists_url: String?,
    var hub_url: String?,
    var issue_search_url: String?,
    var issues_url: String?,
    var keys_url: String?,
    var label_search_url: String?,
    var notifications_url: String?,
    var organization_url: String?,
    var organization_repositories_url: String?,
    var organization_teams_url: String?,
    var public_gists_url: String?,
    var rate_limit_url: String?,
    var repository_url: String?,
    var repository_search_url: String?,
    var current_user_repositories_url: String?,
    var starred_url: String?,
    var starred_gists_url: String?,
    var user_url: String?,
    var user_organizations_url: String?,
    var user_repositories_url: String?,
    var user_search_url: String?
)