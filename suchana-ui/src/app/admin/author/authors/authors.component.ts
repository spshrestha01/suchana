import { Component, OnInit } from '@angular/core';
import {AuthorService} from "../../../services/author.service";
import {Author} from "../../../models/Author";
import {CategoryService} from "../../../services/category.service";

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.css']
})
export class AuthorsComponent implements OnInit {

  users = [];
  userToCreate : Author;
  categories = [];
  user: Author;

  constructor(private authorService: AuthorService, private categoryService: CategoryService) { }

  ngOnInit() {
    this.getAuthors();
    this.getCategories();
  }

  getCategories(){
    this.categoryService.getCategories().subscribe(data => {
      this.categories = data;
    })
  }

  getAuthors(){
    this.authorService.getAuthors().subscribe(data => {
      this.users = data;
    });
  }

  editAuthor(author) {
    this.user = author;
  }

  submitEditAuthor() {
    this.authorService.updateAuthor(this.user).subscribe(() => this.getAuthors());
    this.user = null;
  }

  createAuthorForm(){
    this.userToCreate = new Author();
  }

  createAuthor(){
    this.authorService.createAuthor(this.userToCreate).subscribe( (data) => this.users.push(data));
    this.userToCreate = null;

  }

  cancel(){
    this.user = null;
    this.userToCreate = null;
  }

}
