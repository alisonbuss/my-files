
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { Subscription } from 'rxjs';

import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'authenticate-account',
  templateUrl: './authenticate.component.html',
  styleUrls:  ['./authenticate.component.css']
})
export class AuthenticateComponent implements OnInit {

  private model: any = {email: "", password: ""};
  private routeRecord: Subscription;

  constructor(
    private route: ActivatedRoute, 
    private router: Router,
    private authService: AuthService) { 
    
  }

  ngOnInit() {
    this.routeRecord = this.route.params.subscribe(
      (params: any) => {
        console.log(params);
      }
    );
  }

  public onSubmitLogin(form: FormGroup) {
    console.log(form);
    if(form.valid) {
      console.log("Form Valid!!");
      console.log(this.model);
      this.authService.authenticate(this.model.email, this.model.password);
    } else {
      console.log("Form Invalid!!");
      console.log(this.model);
    }
  }

  public ngOnDestroy() {
    this.routeRecord.unsubscribe();
  }

}
