import { Product } from './product';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/products';

  constructor(private httpClient: HttpClient) {}

  getProductList(): Observable<Product[]> {
    return this.httpClient
      .get<GetResponse>(this.baseUrl)
      .pipe(map((response) => response._embedded.products));
  }

  removeProduct(product: Product): Observable<{}> {
    return this.httpClient.delete(product['_links']['self']['href']);
  }

  updateProduct(product: Product): Observable<{}> {
    return this.httpClient.put(product['_links']['self']['href'], product);
  }

  createProduct(product: Product): Observable<{}> {
    return this.httpClient.post(this.baseUrl, product);
  }
}

interface GetResponse {
  _embedded: {
    products: Product[];
  };
}
