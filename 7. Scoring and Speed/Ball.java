import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Ball {
   private final int BALL_DIAMETER = 30;

   // Store the balls x, y location
   private int BallX = 400;
   private int BallY = 250;

   // Store the balls x & y movement
   private int MoveX = -3;
   private int MoveY = 3;

   // Create Game reference variable
   private SimplePong simplePong;

   // Create a ball object with a reference to the game board
   public Ball(SimplePong simplePong) {
      this.simplePong = simplePong;
   }

   // Move the ball, check for collision
   void move() {

      // Move the ball by adding x, y integers to current location
      BallX = BallX + MoveX;
      BallY = BallY + MoveY;

      // If the ball hits either paddle, reverse direction, play sound
      if (simplePong.player.getBounds().intersects(getBounds())
            || simplePong.computer.getBounds().intersects(getBounds())) {
         Sound.BALL.play();
         MoveX = -MoveX; // Reverse horizontal direction
      }

      // If the ball runs into the top or botton border, reverse direction
      if (BallY < 0 || BallY + BALL_DIAMETER > simplePong.getHeight()) {
         MoveY = -MoveY; // Reverse the vertical direction of the ball
      }

      // If the ball runs into the left border, Computer wins
      if (BallX + MoveX < 0) {
         MoveX = -MoveX; // Reverse the horizontal direction of the ball
         MoveX = MoveX + SimplePong.gameSpeed;
         increaseMoveY();
         BallX = simplePong.getWidth() / 2;
         simplePong.computerScore++;
      }

      // If the ball runs into the right border, Player wins
      if (BallX + BALL_DIAMETER > simplePong.getWidth()) {
         MoveX = -MoveX; // Reverse the horizontal direction of the ball
         MoveX = MoveX - SimplePong.gameSpeed;
         increaseMoveY();
         BallX = simplePong.getWidth() / 2;
         simplePong.playerScore++;
      }

      if (simplePong.playerScore >= SimplePong.WIN) {
         simplePong.gameOver();
      }

      if (simplePong.computerScore >= SimplePong.WIN) {
         simplePong.gameOver();
      }
   }

   void increaseMoveY() {
      if (MoveY < 0) {
         MoveY = MoveY - SimplePong.gameSpeed;
      } else {
         MoveY = MoveY + SimplePong.gameSpeed;
      }
   }

   // Paint the ball/circle
   public void paint(Graphics2D g) {
      g.setColor(Color.DARK_GRAY); // Change the paint color to DARK GRAY
      g.fillOval(BallX, BallY, BALL_DIAMETER, BALL_DIAMETER);
   }

   // Create rectangle for detecting collisions
   public Rectangle getBounds() {
      return new Rectangle(BallX, BallY, BALL_DIAMETER, BALL_DIAMETER);
   }
}