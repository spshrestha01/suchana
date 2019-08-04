import {Component, OnInit} from '@angular/core';
import {CategoryService} from "../../../services/category.service";
import {Category} from "../../../models/Category";

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  catergories = [];

  editingCategories = false;
  categoryToEdit;

  creatingCategory = false;
  categoryToCreate;

  constructor(private categoryService: CategoryService) { }

  ngOnInit() {
    this.getCategories();
  }

  getCategories() {
    this.categoryService.getCategories().subscribe(data => this.catergories = data);
  }

  editCategories(category) {
    this.editingCategories = true;
    this.categoryToEdit = category;
  }

  submitCategoryToEdit(category) {
    this.editingCategories = false;
    this.categoryService.updateCategory(category).subscribe((data) => this.categoryToEdit = data);
  }

  deleteCategory(category) {
    this.categoryService.deleteCategory(category.id).subscribe(() => this.getCategories());
  }

  createCategoryForm() {
    this.creatingCategory = true;
    this.categoryToCreate = new Category();
  }

  createCategory(category) {
    this.categoryService.createCategory(category).subscribe((data) => this.catergories.push(data));
    this.creatingCategory = false;
  }

  cancel() {
    this.editingCategories = false;
    this.creatingCategory = false;
  }

}
