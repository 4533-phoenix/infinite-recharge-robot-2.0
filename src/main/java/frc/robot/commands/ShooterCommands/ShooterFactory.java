package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class ShooterFactory {
    public static Command flywheelOutCommand() {
        return new InstantCommand(
            () -> Robot.shooter.flywheelOut(),
            Robot.shooter
        );
    }
    public static Command flywheelInCommand() {
        return new InstantCommand(
            () -> Robot.shooter.flywheelIn(),
            Robot.shooter
        );
    }
    public static Command flywheelStopCommand() {
        return new InstantCommand(
            () -> Robot.shooter.flywheelStop(),
            Robot.shooter
        );
    }
    public static Command flywheelAndIntakeOutCommand() {
        return new InstantCommand(
            () -> Robot.shooter.flywheelAndIntakeStop(),
            Robot.shooter
        );
    }
}

