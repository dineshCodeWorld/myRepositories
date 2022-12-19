import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';

@Component({
  selector: 'app-change-role',
  templateUrl: './change-role.component.html',
  styleUrls: ['./change-role.component.css']
})
export class ChangeRoleComponent implements OnInit {

  constructor(private service:ServicesService,private fb:FormBuilder) { }
  userDto!:FormGroup;
  response!:string;

  ngOnInit(): void
   {
     this.userDto = this.fb.group({
                     email:['',[Validators.required,Validators.email]],
                     role:['',[Validators.required]]
   })
   }

    public changeRole()
    {
      this.service.changeRole(this.userDto.value).subscribe(response=>this.response=response);
    }

}
