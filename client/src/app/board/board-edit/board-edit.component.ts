import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { BoardService } from '../board.service';
import { Board } from '../board';
import { map, switchMap } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-board-edit',
  templateUrl: './board-edit.component.html'
})
export class BoardEditComponent implements OnInit {

  id: string;
  board: Board;
  feedback: any = {};

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private boardService: BoardService) {
  }

  ngOnInit() {
    this
      .route
      .params
      .pipe(
        map(p => p.id),
        switchMap(id => {
          if (id === 'new') { return of(new Board()); }
          return this.boardService.findById(id);
        })
      )
      .subscribe(board => {
          this.board = board;
          this.feedback = {};
        },
        err => {
          this.feedback = {type: 'warning', message: 'Error loading'};
        }
      );
  }

  save() {
    this.boardService.save(this.board).subscribe(
      board => {
        this.board = board;
        this.feedback = {type: 'success', message: 'Save was successful!'};
        setTimeout(() => {
          this.router.navigate(['/boards']);
        }, 1000);
      },
      err => {
        this.feedback = {type: 'warning', message: 'Error saving'};
      }
    );
  }

  cancel() {
    this.router.navigate(['/boards']);
  }
}
