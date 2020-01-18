
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
    private final Shooter SHOOTER = new Shooter();

    // SHOOTER COMMANDS
    
    private final StartEndCommand shootAtSpeed = new StartEndCommand(
        
    // TODO: change set speed parameter to variable if vision processing works.
        
        //Runnable on initialise
        () -> SHOOTER.setSpeed(1),
        //Runnable on end
        () -> SHOOTER.stopShooter(),
        SHOOTER


    );
  
    // MAKE A NEW JOYSTICK

    public final Joystick opController = new Joystick(OPERATOR_CONTROLLER);

    // SHOOT BUTTON (TOGGLEABLE)

    private final JoystickButton shootButton = new JoystickButton(opController, SHOOT_BUTTON);

    public RobotContainer() {
        configureButtonActions();
    }

    /**
     * Config button actions: it changes what does each button do. Don't touch this to change bindings
     */
    private void configureButtonActions() {
        
        // SHOOT BUTTONS
        // TODO - this might not work. Check (I think it does... see Button.class)
        shootButton.toggleWhenPressed(shootAtSpeed);
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