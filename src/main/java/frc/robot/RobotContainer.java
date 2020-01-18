
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

import static frc.robot.Constants.*;

public class RobotContainer {

    // SUBSYSTEMS
    private final Intake INTAKE = new Intake();

    // INTAKE COMMANDS
    private final StartEndCommand deployIntake = new StartEndCommand(
        () -> INTAKE.deploySpeed(DEPLOY_INTAKE_SPEED),
        () -> INTAKE.deploySpeed(0),
        INTAKE
    );

    private final InstantCommand intakeOn = new InstantCommand(
        () -> INTAKE.wheelSpeed(WHEEL_INTAKE_SPEED),
        INTAKE
    );

    private final InstantCommand intakeOff = new InstantCommand(
        () -> INTAKE.wheelSpeed(0),
        INTAKE
    );

    private final StartEndCommand retractIntake = new StartEndCommand(
    () -> INTAKE.deploySpeed(-DEPLOY_INTAKE_SPEED),
    () -> INTAKE.deploySpeed(0),
    INTAKE
    );

    // TODO: PISTON INTAKE

    private final StartEndCommand pistonDeploy = new StartEndCommand(
        () -> INTAKE.deployPiston(),
        () -> INTAKE.pistonOff(),
        INTAKE

    );

    private final StartEndCommand pistonRetract = new StartEndCommand(
        () -> INTAKE.retractPiston(),
        () -> INTAKE.pistonOff(),
        INTAKE
    );


  
    // MAKE A NEW JOYSTICK

    public final Joystick opController = new Joystick(OPERATOR_CONTROLLER);
  
    // CONFIG BUTTON BINDINGS (See constants.java to change specific ports etc.)

    // CLIMB BUTTONS

    // INTAKE BUTTONS

    private final JoystickButton deployIntakeButton = new JoystickButton(opController,DEPLOY_INTAKE),
                                 retractIntakeButton = new JoystickButton(opController, RETRACT_INTAKE),
                                 endIntakeButton = new JoystickButton(opController, END_INTAKE),
                                 runIntakeButton = new JoystickButton(opController, RUN_INTAKE);
    

    // PISTON-Y INTAKE BUTTONS
    // TODO: piston/motor change

    private final JoystickButton pistonDeployIntakeButton = new JoystickButton(opController, DEPLOY_INTAKE),
                                 pistonRetractIntakeButton = new JoystickButton(opController, RETRACT_INTAKE);
    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */

    public RobotContainer() {
        configureButtonActions();
    }

    /**
     * Config button actions: it changes what does each button do. Don't touch this to change bindings
     */
    private void configureButtonActions() {

        // TODO- add buttons for intake and change climb buttons

        // INTAKE BUTTONS
        deployIntakeButton.whenPressed(deployIntake);
        retractIntakeButton.whenPressed(retractIntake);
        endIntakeButton.whenPressed(intakeOff.andThen(retractIntake.withTimeout(1)));
        runIntakeButton.whenPressed(deployIntake.withTimeout(1).andThen(intakeOn));

        // TODO: either above or below is redundant. fix.

        // PISTON-Y INTAKE BUTTONS
        pistonDeployIntakeButton.whenPressed(pistonDeploy.withTimeout(1).andThen(intakeOn));
        pistonRetractIntakeButton.whenPressed(intakeOff.andThen(pistonRetract.withTimeout(1)));


    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */

    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;

    }

}