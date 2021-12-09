package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous(name = "RedUpperAuto")
public class RedUpperAuto extends AutoBasic1
{

    SampleMecanumDrive drive;

    @Override
    public void runOpMode() throws InterruptedException
    {
        drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(new Pose2d(0,0, Math.toRadians(270)));
        waitForStart();

        while (opModeIsActive() && !isStopRequested())
        {
            initTeam(true);
            setupOpMode();
            initArm();

            /// step 1 ///
            GrabberMove(true);
            drive.followTrajectory(AutoPaths.RT_traj21); //moves slightly towards the goal
            ArmMoveTo(3150);
            drive.followTrajectory(AutoPaths.RT_traj22); //moves to the goal ready to place the element
            sleep(1200);
            GrabberMove(false);
            IntakeMove(-1);
            sleep(500);
            IntakeMove(0);
            ArmMoveTo(0);
            drive.followTrajectory(AutoPaths.RT_traj23); //drives to the wall
            IntakeMove(1);
            drive.followTrajectory(AutoPaths.RT_traj24); //drives to the hub to pick up an element
            sleep(2000);
            IntakeMove(0);
            GrabberMove(true);

            /// step 2 ///
            drive.followTrajectory(AutoPaths.RT_traj25); //drives backwards out of the hub
            ArmMoveTo(3150);
            drive.followTrajectory(AutoPaths.RT_traj26); //drives to the goal ready to place the element
            sleep(1200);
            GrabberMove(false);
            IntakeMove(-1);
            sleep(500);
            IntakeMove(0);
            ArmMoveTo(0);
            drive.followTrajectory(AutoPaths.RT_traj27); //drives to the wall
            IntakeMove(1);
            drive.followTrajectory(AutoPaths.RT_traj28); //drives to the hub ready to pick up an element
            sleep(2000);
            IntakeMove(0);
            GrabberMove(true);

            /// step 3 ///
            drive.followTrajectory(AutoPaths.RT_traj29); // drives backwards out of the hub
            ArmMoveTo(3150);
            drive.followTrajectory(AutoPaths.RT_traj210); // drives to the goal ready to place the element
            sleep(1200);
            GrabberMove(false);
            IntakeMove(-1);
            sleep(500);
            IntakeMove(0);
            ArmMoveTo(0);
            drive.followTrajectory(AutoPaths.RT_traj211); //drives to the wall
            IntakeMove(1);
            drive.followTrajectory(AutoPaths.RT_traj212); //drives into the hub and parks.

            break;
        }


        requestOpModeStop();
    }
}