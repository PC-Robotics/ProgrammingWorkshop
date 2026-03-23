package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Example Teleop")
public class ExampleTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motor;
        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive()) {
            double power = gamepad1.left_stick_y;
            motor.setPower(power);
        }
    }
}
