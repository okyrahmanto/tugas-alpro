package tugasalpro.views;

import java.util.List;
import java.util.Scanner;

import tugasalpro.ApplicationSession;
import tugasalpro.managers.BookingManager;
import tugasalpro.models.*;

public class BookingHistoryPage
{
    private BookingManager bookingManager;
    private Scanner scanner;
    public BookingHistoryPage()
    {
        bookingManager = new BookingManager();
        scanner = new Scanner(System.in);
    }
    public void show()
    {
        System.out.println("BOOKING HISTORY");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%5s %10s %10s %30s %10s %10s %10s", "N0", "KODE BOOKING", "TANGGAL", "JML.PENUMPANG", "KODE JADWAL", "TOTAL", "STATUS");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        List<Booking> bookings = bookingManager.getAll(ApplicationSession.getLoggedUser());
       int no=1;
        for(Booking booking : bookings)
        {
            System.out.printf("%5s %10s %10s %10s %10s %10s %10s",
            String.valueOf(no), booking.getBookingId(), String.valueOf(booking.getBookingDate()),String.valueOf(booking.getJumlahPenumpang()),
                booking.getKodeJadwal(),String.valueOf(booking.getTotalPembayaran()),(booking.IsBayar()?"paid" : "not paid"));
           System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            no++;
        }
        System.out.println();
        System.out.println("1. Detail");
        System.out.println("99. Keluar");
        int pilihan = scanner.nextInt();
        switch(pilihan)
        {
            case 1:
                BookingPage bookingPage=new BookingPage();
                bookingPage.showDetail();
                break;
            case 99:
                UserMenuPage userMenuPage = new UserMenuPage();
                userMenuPage.ShowMenuPengguna();
                break;
        }
        
    }
}