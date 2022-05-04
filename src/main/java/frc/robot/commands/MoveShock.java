// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class MoveShock extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Pneumatics m_pneumatics;
  private final boolean cylinder;
  private final boolean position;
  private Timer timer;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MoveShock(Pneumatics p, boolean shock, boolean pos) {
    m_pneumatics = p;
    cylinder = shock;
    position = pos;
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(p);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(cylinder == true){ //left because im a lefty...
      if(position == true){ //go up
        m_pneumatics.leftShockUp();
      }
      else{ //down
        m_pneumatics.leftShockDn();
      }
    }
    else{ //right
      if(position == true){ //up
        m_pneumatics.rightShockUp();
      }
      else{ //down
        m_pneumatics.rightShockDn();
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(cylinder == true){
      m_pneumatics.disableLeftShock();
    }
    else{
      m_pneumatics.disableRightShock();
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() > 2;
  }
}
