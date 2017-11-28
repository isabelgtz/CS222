public class IntGrid2D implements IIntGrid2D
{
  private IntPoint2D[][] point_grid = new IntPoint2D[3][3];
  private char[][] char_grid = new char[3][3];

  public IntGrid2D (int upper_left_x, int upper_left_y, int lower_right_x, int lower_right_y, char fill_value)
  {
    for (int r = 0; r < 3; r++)
    {
      for (int c = 0; c <3; c++)
      {
        char_grid[r][c] = fill_value;
      }
    }

    for (int r = 0; r < 3; r++)
    {
      for (int c = 0; c <3; c++)
      {
        point_grid[r][c] = new IntPoint2D(upper_left_x + r, upper_left_y - c);
      }
    }


  }

  public void setPoint (IIntPoint2D p, char v)
  {
    for (int r = 0; r < 3; r ++)
    {
      for (int c = 0; c < 3; c ++)
      {
        if (point_grid[r][c].equals(p))
        {
          char_grid[r][c] = v;
        }
      }
    }
  }

  public char getPoint (IIntPoint2D p)
  {
    char value = ' ';
    for (int r = 0; r< 3; r++)
    {
      for (int c = 0; c < 3; c++)
      {
        if (point_grid[r][c].equals(p))
        {
          value = char_grid[r][c];
        }
      }
    }
    return value;
  }

  public IIntPoint2D getUpperLeftCorner ()
  {
    return point_grid[0][0];
  }

  public IIntPoint2D getLowerRightCorner ()
  {
    return point_grid[2][2];
  }

}
