import { Component, OnInit } from '@angular/core';
import { BoardFilter } from '../board-filter';
import { BoardService } from '../board.service';
import { Board } from '../board';

@Component({
  selector: 'app-board',
  templateUrl: 'board-list.component.html'
})
export class BoardListComponent implements OnInit {

  filter = new BoardFilter();
  selectedBoard: Board;
  feedback: any = {};

  get boardList(): Board[] {
    return this.boardService.boardList;
  }

  constructor(private boardService: BoardService) {
  }

  ngOnInit() {
    this.search();
  }

  search(): void {
    this.boardService.load(this.filter);
  }

  select(selected: Board): void {
    this.selectedBoard = selected;
  }

  delete(board: Board): void {
    if (confirm('Are you sure?')) {
      this.boardService.delete(board).subscribe(() => {
          this.feedback = {type: 'success', message: 'Delete was successful!'};
          setTimeout(() => {
            this.search();
          }, 1000);
        },
        err => {
          this.feedback = {type: 'warning', message: 'Error deleting.'};
        }
      );
    }
  }
}
