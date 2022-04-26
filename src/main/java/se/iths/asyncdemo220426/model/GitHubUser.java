package se.iths.asyncdemo220426.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class GitHubUser {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String name;
    private String html_url;
    private String created_at;
    private int followers;

    public String getName() {
        return name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public int getFollowers() {
        return followers;
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "name='" + name + '\'' +
                ", html_url='" + html_url + '\'' +
                ", created_at='" + created_at + '\'' +
                ", followers=" + followers +
                '}';
    }
}
