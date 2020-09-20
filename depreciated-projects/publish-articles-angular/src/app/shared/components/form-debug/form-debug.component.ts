
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'comp-form-debug',
  templateUrl: './form-debug.component.html',
  styleUrls:  ['./form-debug.component.css']
})
export class FormDebugComponent implements OnInit {

  @Input() form;

  constructor() { }

  public ngOnInit() {

  }

}