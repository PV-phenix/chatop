import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Country } from '@core/models/Olympic';
import { BehaviorSubject, Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Participation } from '../models/Participation';
import { ErrorMessageService } from '@core/services/error-message.service';


@Injectable({
  providedIn: 'root',
  
})
export class OlympicService {
  

  private olympicUrl = './assets/mock/olympic.json';
  private olympics$ = new BehaviorSubject<any>(undefined);
  private tab:number[]=[];
  errorMessage!:string;
  myCondition : boolean=false;



  

  constructor(private http: HttpClient,  private errorMessageSvc: ErrorMessageService) {}


  loadInitialData() {
    return this.http.get<Country[]>(this.olympicUrl).pipe(
      tap((value) => this.olympics$.next(value)),
      catchError((error, caught) => {
        // TODO: improve error handling
        console.error(error);
        // can be useful to end loading state and let the user know something went wrong
        this.olympics$.next(null);
        return caught;
      })
    );
  }


  getOlympics() 
  {
    return this.olympics$.asObservable();
  }

  getAllCountry(): Observable<Country[]>
  {
    return this.http.get<Country[]>(this.olympicUrl).pipe(
      tap((value) => this.olympics$.next(value)),
      catchError((error, caught) => {
        // TODO: improve error handling
        console.error(error);
        // can be useful to end loading state and let the user know something went wrong
        this.olympics$.next(null);
        return caught;
      })
    );

    
  }

  getCountry(id:Number): Observable<Country[]>
  {
    return this.http.get<Country[]>(this.olympicUrl).pipe
    (
      tap(() => this.olympics$.next(id)),
      catchError((error, caught) =>
                  {
                    console.error(error);
                    // can be useful to end loading state and let the user know something went wrong
                    this.olympics$.next(null);
                    return caught;
                  }
                )
    );
  }

  getDetailCountryById(participationId: Number): Observable<Participation[]>{return this.http.get<Participation[]>(this.olympicUrl).pipe(tap(() => this.olympics$.next(participationId)))};

  ngOnDestroy(): void 
  {
    this.olympics$.complete;
  }
}

