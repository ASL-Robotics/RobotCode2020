
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
    private final InstantCommand intakeOn = new InstantCommand(
        () -> INTAKE.wheelSpeed(WHEEL_INTAKE_SPEED),
        INTAKE
    );

    private final InstantCommand intakeOff = new InstantCommand(
        () -> INTAKE.wheelSpeed(0),
        INTAKE
    );
    /* CODE FOR 1 MOTOR 
    private final StartEndCommand fore = new StartEndCommand(
        () -> INTAKE.wheelOnFore(),
        () -> INTAKE.wheelOff(),
        INTAKE
    )
    private final StartEndCommand back = new StartEndCommand(
        () -> INTAKE.wheelOnBack(),
        () -> INTAKE.wheelOff(),
        INTAKE
    )


    */

    // PISTON INTAKE

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

    // PISTON-Y INTAKE BUTTONS
    // TODO: piston/motor change

    private final JoystickButton pistonDeployIntakeButton = new JoystickButton(opController, DEPLOY_INTAKE),
                                 pistonRetractIntakeButton = new JoystickButton(opController, RETRACT_INTAKE);
                               //wheelOnFore = new JoystickButton(opController, FORE_BUTTON),
                               //wheelOnBack = new JoystickButton(opController, BACK_BUTTON);
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
        // PISTON-Y INTAKE BUTTONS
        pistonDeployIntakeButton.whenPressed(pistonDeploy.withTimeout(1).andThen(intakeOn));
        pistonRetractIntakeButton.whenPressed(intakeOff.andThen(pistonRetract.withTimeout(1)));
        /* CODE FOR TESTING
        wheelOnFore.whenHeld(fore);
        wheelOnBack.whenHeld(back);
        */
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