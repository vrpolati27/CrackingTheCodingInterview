package leetcode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class SudokuSolver {

    char[][] board = new char[9][9];
    Map<Cell, List<Character>> potentialCandidatesMap = new HashMap<>();

    public SudokuSolver(char[][] board){
        this.board = board;
        findPotentialCandidates();
    }

    public void solveSudoku(){
        findAndUpdateNakedSingle();
        findAndUpdateHiddenSingle();
        // lookForNakedPair();
        // findAndUpdatePointingPairs();
    }


    private void lookForNakedPair(){
        lookForNakedPair(0);
        lookForNakedPair(1);
        lookForNakedPairInGrids();
    }

    private void lookForNakedPair(int _mn){
        for(int m1=0;m1<9;m1++){
            List<Character> missing = new ArrayList<>(9);
            missing.add('1');missing.add('2');missing.add('3');
            missing.add('4');missing.add('5');missing.add('6');
            missing.add('7');missing.add('8');missing.add('9');
            int emptySpot = -1;
            for(int m2=0;m2<9;m2++){
                int row = _mn == 0 ? m1 : m2;
                int col = _mn == 0 ? m2 : m1;
                char ch = board[row][col];
                if(ch != '.')
                   missing.remove(new Character(ch));
                else
                    emptySpot = _mn == 0? col : row;
            }

            if(missing.size()>1){
                for(int c1=0;m1<missing.size()-1;m1++){
                    for(int c2=c1+1;c2<missing.size();c2++){
                        char[] _chPair = {missing.get(c1), missing.get(c2)};
                        List<Integer> chPairColList = new ArrayList<>();
                        for(int m2=0;m2<9;m2++){
                            int row = _mn == 0 ? m1 : m2;
                            int col = _mn == 0 ? m2 : m1;
                            if(board[row][col] == '.'){
                                List<Character> list = potentialCandidatesMap.get(new Cell(row,col));
                                if(list.size() == 2 && list.contains(_chPair[0]) &&
                                        list.contains(_chPair[1]) ){
                                   chPairColList.add(col);
                                }
                            }
                        }

                        if(chPairColList.size()==2){
                            Cell cell1 = null;
                            Cell cell2 = null;
                            if(_mn==0){
                                cell1 = new Cell(m1,chPairColList.get(0));
                                cell2 = new Cell(m1,chPairColList.get(1));
                            } else if(_mn==1){
                                cell1 = new Cell(chPairColList.get(0),m1);
                                cell2 = new Cell(chPairColList.get(1),m1);
                            }
                            updateCandidatesAfterNakedPair(cell1,cell2,_chPair,_mn);
                        }

                    }
                }
            }else if(missing.size()==1){
                int row = _mn == 0 ? m1 : emptySpot;
                int col = _mn == 0 ? emptySpot : m1;
                board[row][col] = missing.get(0);
                reduceCandidateList(new Cell(row,col),missing.get(0));
                potentialCandidatesMap.remove(new Cell(row,col));
            }
        }
    }

    private void updateCandidatesAfterNakedPair(Cell cell1, Cell cell2,char[] values,int in){
        if(in==0 || in == 1){
          for(int m1=0;m1<9;m1++){
             int _cRow = in == 0 ? cell1.row: m1;
             int _cCol = in == 0 ? m1: cell1.col;
              Cell _cell = new Cell(_cRow,_cCol);
             if(board[_cRow][_cCol] == '.' && _cell!=cell1 && _cell!=cell2){
                 potentialCandidatesMap.get(_cell).remove(new Character(values[0]));
                 potentialCandidatesMap.get(_cell).remove(new Character(values[1]));
             }
          }
        }else if(in == 2){
            int gr = 3 *(cell1.row/3);
            int gc = 3 *(cell1.col/3);
            for(int row=gr;row<(gr+3);row++){
                for(int col=gc;col<(gc+3);col++){
                    Cell c1 = new Cell(row,col);
                    if(board[c1.row][c1.col] == '.' && c1 != cell1 && c1 != cell2 ){
                        potentialCandidatesMap.get(c1).remove(new Character(values[0]));
                        potentialCandidatesMap.get(c1).remove(new Character(values[1]));
                    }
                }
            }
        }
    }


    private void lookForNakedPairInGrids(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                List<Character> missing = new ArrayList<>(9);
                missing.add('1');missing.add('2');missing.add('3');
                missing.add('4');missing.add('5');missing.add('6');
                missing.add('7');missing.add('8');missing.add('9');
                /* grid #(i,j)*/ Cell last = null;
                for(int c1=3*i;c1<(3*i+3);c1++){
                    for(int c2=3*j;c2<(3*j+3);c2++){
                      char ch = board[c1][c2];
                      if(ch != '.')
                          missing.remove(new Character(ch));
                      else
                          last = new Cell(c1,c2);
                    }
                }

                if(missing.size()>1){
                  for(int m1=0;m1<missing.size()-1;m1++){
                      for(int m2=m1+1;m2<missing.size();m2++){
                        char[] _chset = {missing.get(m1), missing.get(m2)};
                        List<Cell> cellList = new ArrayList<>();
                          for(int c1=3*i;c1<(3*i+3);c1++){
                              for(int c2=3*j;c2<(3*j+3);c2++){
                                  Cell _1 = new Cell(c1,c2);
                                  if(board[c1][c2] =='.' && potentialCandidatesMap.get(_1).size()==2 &&
                                          potentialCandidatesMap.get(_1).contains(_chset[0])
                                          && potentialCandidatesMap.get(_1).contains(_chset[1])){
                                      cellList.add(_1);
                                  }
                              }
                          }
                        if(cellList.size()==2){
                          updateCandidatesAfterNakedPair(cellList.get(0),cellList.get(1),
                                  _chset,2);
                        }
                      }
                  }
                }else if(missing.size()==1){
                    /* Naked single. */
                    board[last.row][last.col] = missing.get(0);
                    reduceCandidateList(last,missing.get(0));
                    potentialCandidatesMap.remove(last);
                }
            }
        }
    }

    private void findAndUpdateHiddenSingle(){
        findAndUpdateHiddenSingleInRows();
        findAndUpdateHiddenSingleInColumns();
        findAndUpdateHiddenSingleInGrids();
    }

    private void findAndUpdateHiddenSingleInRows(){
        boolean canReduce = true;
        while(potentialCandidatesMap.size() != 0 && canReduce){
            canReduce = false;
            for(int row=0;row<9;row++){
                char[] missing = {'1','2','3','4','5','6','7','8','9'};
                for(char _ch:missing){
                    int _chCount = 0; Cell lastCell = null;
                    for(int col=0;col<9;col++){
                        char ch = board[row][col];
                        if(ch == '.' && potentialCandidatesMap.get(new Cell(row,col))
                                .contains(new Character(_ch)) ){
                            _chCount++;
                            lastCell = new Cell(row,col);
                        }
                    }
                    if(_chCount == 1){
                        canReduce = true;
                        board[lastCell.row][lastCell.col] = _ch;
                        reduceCandidateList(lastCell,_ch);
                        potentialCandidatesMap.remove(lastCell);
                    }
                }
            }
        }
    }

    private void findAndUpdateHiddenSingleInColumns(){
        boolean canReduce = true;
        while(potentialCandidatesMap.size() != 0 && canReduce) {
            canReduce = false;
            for(int col=0;col<9;col++){
                char[] missing = {'1','2','3','4','5','6','7','8','9'};
                for(char _ch:missing){
                    int _chCount = 0; Cell lastCell = null;
                    for(int row=0;row<9;row++){
                        char ch = board[row][col];
                        if(ch == '.' && potentialCandidatesMap.get(new Cell(row,col))
                                .contains(_ch)){
                            _chCount++;
                            lastCell = new Cell(row,col);
                        }
                    }

                    if(_chCount == 1){
                        board[lastCell.row][lastCell.col] = _ch;
                        reduceCandidateList(lastCell,_ch);
                        potentialCandidatesMap.remove(lastCell);
                    }
                }
            }
        }
    }

    private void findAndUpdateHiddenSingleInGrids(){
        boolean canReduce = true;
        while(potentialCandidatesMap.size() != 0 && canReduce) {
            canReduce = false;
            for(int c1=0;c1<9;c1=c1+3){
                for(int c2=0;c2<9;c2+=3){
                    char[] missing = {'1','2','3','4','5','6','7','8','9'};
                    for(char _ch:missing){
                        int _chCount = 0;
                        Cell lastCell = null;
                        for(int row=c1;row<c1+3;row++){
                            for(int col=c2;col<c2+3;col++){
                                char ch = board[row][col];
                                if(ch == '.' && potentialCandidatesMap.get(new Cell(row,col))
                                        .contains(_ch)){
                                    _chCount++;
                                    lastCell = new Cell(row,col);
                                }
                            }
                        }
                        if(_chCount == 1){
                            board[lastCell.row][lastCell.col] = _ch;
                            reduceCandidateList(lastCell,_ch);
                            potentialCandidatesMap.remove(lastCell);
                        }
                    }
                }
            }
        }

    }

    private void findAndUpdatePointingPairs(){
        for(int row=0;row<9;row++){
            List<Character> missing = new ArrayList<>(9);
            missing.add('1'); missing.add('2'); missing.add('3');
            missing.add('4'); missing.add('5'); missing.add('6');
            missing.add('7'); missing.add('8'); missing.add('9');
            int emptySpotCol = -1;
            for(int col=0;col<9;col++){
                char ch = board[row][col];
                if(ch != '.'){
                    missing.remove(new Character(ch));
                }else
                    emptySpotCol = col;
            }
            if(missing.size()>1){
                for(int c1=0;c1<missing.size()-1;c1++){
                    for(int c2=c1+1;c2<missing.size();c2++){
                       char[] _chPair = {missing.get(c1), missing.get(c2)};
                       List<Integer> pairCellColList = new ArrayList<>();
                       for(int col=0;col<9;col++){
                           if(board[row][col] == '.'){
                               Cell cell = new Cell(row,col);
                               if(potentialCandidatesMap.get(cell).contains(_chPair[0]) &&
                                       potentialCandidatesMap.get(cell).contains(_chPair[1])){
                                   pairCellColList.add(col);
                               }
                           }
                       }
                       if(pairCellColList.size()==2 && (
                               (pairCellColList.get(0)>=0 && pairCellColList.get(1)<3) ||
                                       (pairCellColList.get(0)>2 && pairCellColList.get(1)<6) ||
                                       (pairCellColList.get(0)>5 && pairCellColList.get(1)<9))  ){
                               reduceCandidateListInGrid(new Cell(row,pairCellColList.get(0)),
                                       new Cell(row,pairCellColList.get(1)),_chPair);
                       }
                    }
                }
            } else if(missing.size()==1){
                board[row][emptySpotCol] = missing.get(0);
                reduceCandidateList(new Cell(row,emptySpotCol),missing.get(0));
                potentialCandidatesMap.remove(new Cell(row,emptySpotCol));
            }
        }
    }

    private void reduceCandidateListInGrid(Cell cell1, Cell cell2, char[] values){
        int gr = 3*(cell1.row/3);
        int gc = 3*(cell1.col/3);
        boolean inSameRow = false;
        if(cell1.row == cell2.row){
         inSameRow = true;
        }

        for(int i=gr;i<(gr+3);i++){
            if(inSameRow && i == cell1.row)
                continue;
            for(int j=gc;j<(gc+3);j++){
               if(!inSameRow && j==cell1.col)
                   continue;
               if(board[i][j] == '.'){
                   potentialCandidatesMap.get(new Cell(i,j)).remove(new Character(values[0]));
                   potentialCandidatesMap.get(new Cell(i,j)).remove(new Character(values[1]));
               }
            }
        }
    }

    private void findAndUpdateNakedSingle(){
        boolean canReduce = true;
        while(potentialCandidatesMap.size() != 0 && canReduce){
             canReduce = false;
            Iterator<Map.Entry<Cell, List<Character>>> iterator = potentialCandidatesMap.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Cell, List<Character>> en = iterator.next();
                if(en.getValue().size()==1){
                    canReduce = true;
                    Cell cell = en.getKey();
                    board[cell.row][cell.col] = en.getValue().get(0);
                    reduceCandidateList(cell,en.getValue().get(0));
                    iterator.remove();
                }
            }
        }
    }

    private void reduceCandidateList(Cell cell, char value){
       /* update row. */
       for(int col=0;col<9;col++){
           char ch = board[cell.row][col];
           if(ch == '.'){
               potentialCandidatesMap.get(new Cell(cell.row,col))
                       .remove(new Character(value));
           }
       }

       /* update column. */
       for(int row=0;row<9;row++){
           char ch = board[row][cell.col];
           if(ch == '.'){
               potentialCandidatesMap.get(new Cell(row,cell.col))
                       .remove(new Character(value));
           }
       }
       /* update grid. */
        int gridMinRow = 3 * (cell.row/3);
        int gridMinCol = 3 * (cell.col/3);
        for(int row=gridMinRow;row<(gridMinRow+3);row++){
           for(int col=gridMinCol;col<(gridMinCol+3);col++){
               char ch = board[row][col];
               if(ch == '.'){
                   potentialCandidatesMap.get(new Cell(row,col))
                           .remove(new Character(value));
               }
           }
        }

    }

    private void findPotentialCandidates(){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                char ch = board[row][col];
                if(ch == '.'){
                    Cell cell = new Cell(row,col);
                  potentialCandidatesMap.put(cell,getPotentialCandidates(cell));
                }
            }
        }
    }

    private List<Character> getPotentialCandidates(Cell cell){
        List<Character> potentialCandidatesList = new ArrayList<>(9);
        potentialCandidatesList.add('1'); potentialCandidatesList.add('2');
        potentialCandidatesList.add('3'); potentialCandidatesList.add('4');
        potentialCandidatesList.add('5'); potentialCandidatesList.add('6');
        potentialCandidatesList.add('7'); potentialCandidatesList.add('8');
        potentialCandidatesList.add('9');

        /* Examine the row in which  cell is */
        for(int col=0;col<9;col++){
            char ch = board[cell.row][col];
            if(ch != '.'){
                potentialCandidatesList.remove(new Character(ch));
            }
        }

        /* Examine the col in which cell is */
        for(int row=0;row<9;row++){
            char ch = board[row][cell.col];
            if(ch != '.'){
                potentialCandidatesList.remove(new Character(ch));
            }
        }

        /* Examine the grid in which cell is */
        int gridMinRow = 3 * (cell.row/3);
        int gridMinCol = 3 * (cell.col/3);
        for(int row=gridMinRow;row<(gridMinRow+3);row++){
            for(int col=gridMinCol;col<(gridMinCol+3);col++){
                char ch = board[row][col];
                if(ch != '.'){
                    potentialCandidatesList.remove(new Character(ch));
                }
            }
        }

        return potentialCandidatesList;
    }

    public void displayMap(){
        for(Map.Entry<Cell, List<Character>> en:potentialCandidatesMap.entrySet()){
            System.out.print(en.getKey()+":[");
            for(char ch:en.getValue()){
                System.out.print(ch+" ");
            }
            System.out.println("]");
        }
    }

    public void displayBoard(){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args){
        try {
            FileReader fr = new FileReader("board.txt");
            Scanner sc = new Scanner(fr);
            char[][] board = new char[9][9];
            for(int line=0;line<board.length;line++){
                for(int col=0;col<board[line].length;col++){
                    board[line][col] = sc.next().charAt(0);
                }
            }
            SudokuSolver solver = new SudokuSolver(board);
            solver.displayBoard();
            System.out.println("----------------------------------");
            solver.solveSudoku();
            solver.displayMap();
            solver.displayBoard();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Cell{
    int row;
    int col;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return new String("["+row+" "+col+"]");
    }

    @Override
    public boolean equals(Object obj) {
        Cell cell = (Cell)obj;
        return new Integer((cell.row+1)*10+(cell.col+1))
                .equals((this.row+1)*10+(this.col+1));
    }

    @Override
    public int hashCode() {
        return new String(""+row+""+col).hashCode();
    }
}


