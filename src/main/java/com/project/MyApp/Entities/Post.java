package com.project.MyApp.Entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "post")
public class Post {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter Long id;
	
	//Long userId; //bunu table oluşturduktan sonra kaldırdık
	
	@Getter @Setter String title;
	
	@Lob
	@Column(columnDefinition = "text")
	@Getter @Setter String text;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	@Getter @Setter User user;
}
