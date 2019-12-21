import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const API_URL = 'http://localhost:8181/api/';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(
    private httpClient: HttpClient,
  ) {
  }

  getAllProduct(): Observable<any> {
    return this.httpClient.get<any>(API_URL + 'product/getAll');
  }
}


