package io.github.adrienkoumgangt.api.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="book_name", nullable=false)
	private String name;
	
	@Column(name="author", nullable=false)
	private String author;
	
	@Column(name="code_isbn", nullable=false)
	private String codeISBN;
	
	@Column(name="date_add", nullable=false)
	private String dateAdd;
	
	@Column(name="date_delete")
	private String dateDelete;
	
	@Column(name="genre")
	private String genere;
	
	@Column(name="number_of_read", nullable=false)
	private Long numerOfRead;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="content", nullable=false)
	private String content;
	
	@Column(name="number_of_like", nullable=false)
	private Long numberOfLike;
	
	public Integer getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getCodeISBN() {
		return this.codeISBN;
	}
	
	public void setCodeISBN(String codeISBN) {
		this.codeISBN = codeISBN;
	}
	
	public String getDateAdd() {
		return this.dateAdd;
	}
	
	public void setDateAdd(String dateAdd) {
		this.dateAdd = dateAdd;
	}
	
	public String getDateDelete() {
		return this.dateDelete;
	}
	
	public void setDateDelete(String dateDelete) {
		this.dateDelete = dateDelete;
	}
	
	public String getGenere() {
		return this.genere;
	}
	
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	public Long getNumberOfRead() {
		return this.numerOfRead;
	}
	
	public void setNumberOfRead(Long numberOfRead) {
		this.numerOfRead = numberOfRead;
	}
	
	public void incrNumberOfRead() {
		this.numerOfRead += 1;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Long getNumberOfLike() {
		return this.numberOfLike;
	}
	
	public void setNumberOfLike(Long numberOfLike) {
		this.numberOfLike = numberOfLike;
	}
	
	public void incrNumberOfLike() {
		this.numberOfLike += 1;
	}
	
	public void decrNumberOfLike() {
		this.numberOfLike -= 1;
	}

}
