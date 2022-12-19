import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  constructor(private service:ServicesService,private fb:FormBuilder) { }
  userDto!:FormGroup;
  response!:string;


  ngOnInit(): void
   {
     this.userDto = this.fb.group({
                     userId:['',Validators.required],
                     firstName:['',[Validators.required,Validators.pattern("[A-Za-z]{2,15}")]],
                     lastName:['',[Validators.required,Validators.pattern("[A-Za-z]{2,15}")]],
                     email:['',[Validators.required,Validators.email]],
   })
   }

   public updateProfile()
   {
     this.service.updateProfile(this.userDto.value).subscribe(response=>this.response=response);
   }
}
