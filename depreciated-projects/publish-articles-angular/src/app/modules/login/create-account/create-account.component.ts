
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { Subscription } from 'rxjs';

import { User } from '../../../models/user.model';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'create-account',
  templateUrl: './create-account.component.html',
  styleUrls:  ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  private model: User = new User();

  private routeRecord: Subscription;

  constructor(
    private route: ActivatedRoute, 
    private router: Router,
    private userService: UserService) { 
    
  }

  public ngOnInit() {
    this.routeRecord = this.route.params.subscribe(
      (params: any) => {
        console.log(params);
      }
    );
  }

  public onKeyUpCheckEmail(email: string): void {
    this.userService.getUserByEmail(email).subscribe(
      data => {
        if(data.length > 0) {
          alert("This email is already registered, please change your email!");
        }
      },
      error => {
        console.log("Error", error);
      }
    );     
  }

  public onSubmitRegister(form: FormGroup) {
    console.log(form);
    if(form.valid) {
      console.log("Form Valid!!");
      console.log(this.model);
      this.userService.createUser(this.model).subscribe(
        data => {
            console.log("POST Request is successful ", data);
            alert("Register successfully, redirecting to the Login!");
            this.router.navigate(['/login']);
        },
        error => {
            console.log("Error", error);
        }
      );     
    } else {
      console.log("Form Invalid!!");
      console.log(this.model);
    }
  }

  public ngOnDestroy(){
    this.routeRecord.unsubscribe();
  }

}
