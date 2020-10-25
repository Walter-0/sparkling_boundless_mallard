import { TestBed } from '@angular/core/testing';
import { BoardService } from './board.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

describe('BoardService', () => {
  let service: BoardService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [BoardService]
    });

    service = TestBed.get(BoardService);
    httpMock = TestBed.get(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
