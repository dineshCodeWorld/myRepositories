import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { UserList } from '../user-list';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private service:ServicesService) { }

  userList!:UserList[];

  ngOnInit(): void {
   this.getUserList();
  }
  public getUserList()
  {
     this.service.getUserList().subscribe(response=>this.userList=response);
  }

}
