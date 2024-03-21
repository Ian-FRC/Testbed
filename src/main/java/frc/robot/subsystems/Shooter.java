// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.Supplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  
  private CANSparkMax shooterangle;
  
  /** Creates a new shooter. */
  public Shooter() {
    shooterangle = new CANSparkMax(Constants.ShooterConstants.LINEAR_ACTUATOR_ID, MotorType.kBrushed);
  }
  
public Command upwardCommand(){
  return startEnd(
    ()->{
      shooterangle.set(Constants.ShooterConstants.ANGLE_SPEED);
    },
    ()-> {
      shooterangle.set(0);
    }
  ).raceWith(
    new WaitCommand(0.1)
    .andThen(new RunCommand(()->{})
    .until(
      ()->shooterangle.getOutputCurrent()==0)
      )
  );

}

public Command downwardCommand(){
  return startEnd(
    ()->{
      shooterangle.set(-Constants.ShooterConstants.ANGLE_SPEED);
    },
    ()->{
      shooterangle.set(0);
    }
    );
}


  @Override
  public void periodic() { 
    SmartDashboard.putNumber("current", shooterangle.getOutputCurrent());

    // This method will be called once per scheduler run
  }
}
