/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.*;

/**
 * For robot commands because RobotContainer is frighteningly messy
 */
public class RobotCommands{

    // CREATE SUBSYSTEMS
    private final ControlPanel CONTROL = new ControlPanel();

    // == COMMANDS == //
    // == CONTROL PANEL MOTOR COMMAND == //
    public final StartEndCommand controlSpin = new StartEndCommand(
        () -> CONTROL.spinnerOn(),
        () -> CONTROL.spinnerOff(),
        CONTROL
    ); 

    // == CONTROL PANEL PISTON COMMAND == //
    
    public final StartEndCommand controlDeploy = new StartEndCommand(
        () -> CONTROL.lifterPistonUp(), 
        () -> CONTROL.lifterPistonOff(),
        CONTROL
    );

    public final StartEndCommand controlRetract = new StartEndCommand(
        () -> CONTROL.lifterPistonDown(), 
        () -> CONTROL.lifterPistonOff(),
        CONTROL
    );

}
        



