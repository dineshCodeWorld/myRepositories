import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { UserDto } from '../user-dto';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.component.html',
  styleUrls: ['./delete-user.component.css']
})
export class DeleteUserComponent implements OnInit {

  constructor(private service:ServicesService,private fb:FormBuilder,private router:Router) { }
  userDto!:FormGroup;
  response!:string;


  ngOnInit(): void
  {
    this.userDto = this.fb.group({
                    email:['',[Validators.required,Validators.email]],
                    password:['',[Validators.required,Validators.pattern("([A-Za-z0-9@.$=]{5,15})")]]
  })
  }
  public deleteUser()
  {
    this.service.deletUser(this.userDto.value).subscribe(response=>this.response=response);
    //  this.router.navigate(['/user-list']);
  }

}
