
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor() { 

  }

  getAuthors() {
    return [
      {id: 1, name: 'Aaaaaaa'},
      {id: 2, name: 'Bbbbbbb'},
      {id: 3, name: 'Ccccccc'},
      {id: 4, name: 'Ddddddd'}
    ];
  }

  getAuthor(id: number) {
    let authors = this.getAuthors();
    for(let aut of authors) {
      if(aut.id == id) {
        return aut
      }
    }
    return null;
  }

}
