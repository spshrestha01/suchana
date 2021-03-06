import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Author} from "../../../models/Author";
import {Category} from "../../../models/Category";

@Component({
  selector: 'app-create-author',
  templateUrl: './create-author.component.html',
  styleUrls: ['./create-author.component.css']
})
export class CreateAuthorComponent implements OnInit {

  @Input('user') author: Author;

  @Input('categories') categories: Category[];

  @Output() createAuthor = new EventEmitter();
  @Output() cancelEvent = new EventEmitter();

  dropdownSettings = {};

  constructor() {
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true,
      ngModelOptions: {
        standalone: true
      }
    };
  }

  ngOnInit() {
  }

  submit() {
    this.createAuthor.next();
  }

  cancel() {
    this.cancelEvent.next();
  }

}
