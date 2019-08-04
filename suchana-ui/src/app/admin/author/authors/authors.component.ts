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

  authors= [];
  categories = [];

  editingAuthor = false;
  authorToEdit;

  creatingAuthor = false;
  authorToCreate;

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
    this.authorService.GetAuthors().subscribe(data => {
      this.authors = data;
    });
  }

  editAuthor(author){
    this.editingAuthor = true;
    this.authorToEdit = author;
  }

  submitAuthorEdit(author){
    this.editingAuthor = false;
    this.authorService.UpdateAuthor(author).subscribe(data => {
      this.authorToEdit = data;
    });
  }

  deleteAuthor(author){
    this.authorService.DeleteAuthor(author.id).subscribe( () => this.getAuthors());
  }

  createAuthorForm(){
    this.creatingAuthor = true;
    this.authorToCreate = new Author();
  }

  createAuthor(author){
    this.authorService.CreateAuthor(author).subscribe( (data) =>
      this.authors.push(data));
  }

  cancel(){
    this.editingAuthor = false;
    this.creatingAuthor = false;
  }

}
