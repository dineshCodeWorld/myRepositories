import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { UserDto } from '../user-dto';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private service:ServicesService) { }

  ngOnInit(): void {
  }


}
