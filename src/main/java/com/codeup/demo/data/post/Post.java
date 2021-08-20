package com.codeup.demo.data.post;

import com.codeup.demo.data.category.Category;
import com.codeup.demo.data.user.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=120)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user id")
    private User user;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="post_category",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private Collection<Category> categories;


    public Post(Long id, String title, String content, User user, Collection<Category> categories) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.categories = categories;
    }

    public Post(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }
}