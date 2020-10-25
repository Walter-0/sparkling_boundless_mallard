import { Board } from './board';
import { BoardFilter } from './board-filter';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

const headers = new HttpHeaders().set('Accept', 'application/json');

@Injectable()
export class BoardService {
  boardList: Board[] = [];
  api = 'http://localhost:8080/api/boards';

  constructor(private http: HttpClient) {
  }

  findById(id: string): Observable<Board> {
    const url = `${this.api}/${id}`;
    const params = { _id: id };
    return this.http.get<Board>(url, {params, headers});
  }

  load(filter: BoardFilter): void {
    this.find(filter).subscribe(result => {
        this.boardList = result;
      },
      err => {
        console.error('error loading', err);
      }
    );
  }

  find(filter: BoardFilter): Observable<Board[]> {
    const params = {
      'name': filter.name,
    };
    const userBoards = 'http://localhost:8080/user/boards';
    return this.http.get<Board[]>(userBoards, {params, headers});
  }

  save(entity: Board): Observable<Board> {
    let params = new HttpParams();
    let url = '';
    if (entity._id) {
      url = `${this.api}/${entity._id.toString()}`;
      params = new HttpParams().set('ID', entity._id.toString());
      return this.http.put<Board>(url, entity, {headers, params});
    } else {
      url = `${this.api}`;
      return this.http.post<Board>(url, entity, {headers, params});
    }
  }

  delete(entity: Board): Observable<Board> {
    let params = new HttpParams();
    let url = '';
    if (entity._id) {
      url = `${this.api}/${entity._id.toString()}`;
      params = new HttpParams().set('ID', entity._id.toString());
      return this.http.delete<Board>(url, {headers, params});
    }
    return null;
  }
}

