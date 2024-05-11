import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ErrorMessageService {
  errorMessage!: string;
  isErrorMsgVisible = false;
  index !:number;
  

  displayError(errorMessage: string) 
  {
    this.errorMessage = errorMessage;
    this.isErrorMsgVisible = true;
  }

  hideError() 
  {
    this.errorMessage = '';
    this.isErrorMsgVisible = false;
  }

}