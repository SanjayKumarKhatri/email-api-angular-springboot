import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailService } from 'src/app/Service/email.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {

  data ={
    to: "",
    subject: "",
    message: ""

}

flag= false;

  constructor(private service : EmailService , private snack : MatSnackBar) { }

  ngOnInit(): void {
  }

  onFormSubmit(){
    console.log("Form submitted");
    console.log("Data : ",this.data);

    if(this.data.to=='' || this.data.subject=='' || this.data.message=='')
     {
      this.snack.open("Field Can not be Empty", "OK");
      return;
    }
    this.flag=true;
    this.service.sendEmail(this.data).subscribe(response  => {
      console.log(response);
      this.flag=false;
      this.snack.open("Send Success !!", "OK");
    },
    error => {
      console.log(error);
      this.flag=false;
      this.snack.open("Error !!", "OK");
    });
    
    
  }

}
