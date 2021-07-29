 var gamePuzzle = wordfindgame.create(words, '#play_content', '#words');

  $('#solve').click( function() {
    wordfindgame.solve(gamePuzzle, words);
  });

  // create just a puzzle, without filling in the blanks and print to console
  var puzzle = wordfind.newPuzzle(
    words,
    {height: 18, width:18, fillBlanks: false}
  );
  wordfind.print(puzzle);

  /////////////////////////////////////////////////
  // FastClick.attach(document.body);

// var wordsToFind = $('#words li').length,
//     colors = ['red', 'green', 'yellow', 'blue', 'purple'],
//     found = 0,
//     clicking = false;


// $('#play_content').mousedown(function(){
//     clicking = true;
// });

// $('#play_content').mouseup(function(){
//   clicking = false;
//   $('.puzzleSquare').removeClass('selected');
// })


// $('#play_content div .puzzleSquare').mouseover().mouseout(function() {

//   if(clicking){
//   // Toggle highlight to box on click
//   $(this).addClass('selected');
//   }
// });