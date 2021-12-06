package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;

public class ClimbFactory {
    public static Command hookUpCommand() {
        return new InstantCommand(
            () -> Robot.climb.hookUp(), 
            Robot.climb
        );
    }

    public static Command hookDownCommand() {
        return new InstantCommand(
            () -> Robot.climb.hookDown(),
            Robot.climb
        );
    }

    public static Command climb() {
        return new InstantCommand(
            () -> Robot.climb.climb(),
            Robot.climb
        );
    }
}
