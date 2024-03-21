// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final Climb m_climb = new Climb();
  // private final Elevator elevator = new Elevator();
  private final Shooter m_shooter = new Shooter();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final XboxController bozoProgrammerController = new XboxController(0);
  private final XboxController kellerbetterthanchristian = new XboxController(1);

  private final JoystickButton elevatorUpButton = 
    new JoystickButton(bozoProgrammerController, XboxController.Button.kY.value);
  private final JoystickButton elevatorDownButton = 
    new JoystickButton(bozoProgrammerController, XboxController.Button.kA.value);
  private final JoystickButton climbUpButton = 
    new JoystickButton(bozoProgrammerController, XboxController.Button.kX.value);
  private final JoystickButton climbDownButton = 
    new JoystickButton(bozoProgrammerController, XboxController.Button.kB.value);

  private final JoystickButton shooterUpButton = 
    new JoystickButton(kellerbetterthanchristian, XboxController.Button.kLeftBumper.value);
  private final JoystickButton shooterDownButton = 
    new JoystickButton(kellerbetterthanchristian, XboxController.Button.kRightBumper.value);

  private final Command shooterUp = m_shooter.upwardCommand();
  private final Command shooterDown = m_shooter.downwardCommand();

  // private final Command elevatorUp = elevator.elevatorUp();
  // private final Command elevatorDown = elevator.elevatorDown();
  // private final Command climbUp = m_climb.climbUp();
  // private final Command climbDown = m_climb.climbDown();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_shooter::exampleCondition)
    // .onTrue(new Shoot(m_shooter));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is
    // pressed,
    // cancelling on release.
    // driver.b().whileTrue(m_shooter.exampleMethodCommand());
    // elevatorUpButton.onTrue(elevatorUp);
    // elevatorDownButton.onTrue(elevatorDown);
    // climbUpButton.whileTrue(climbUp);
    // climbDownButton.whileTrue(climbDown);
    shooterUpButton.whileTrue(shooterUp);
    shooterDownButton.whileTrue(shooterDown);
    SmartDashboard.putData(shooterUp);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}