-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 28, 2020 lúc 06:33 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shopbook`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `commune` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `address`
--

INSERT INTO `address` (`id`, `activeFlag`, `commune`, `createDate`, `description`, `district`, `name`, `phone`, `province`, `updateDate`, `user_id`) VALUES
(3, 1, 'Phường Hòa Hiệp Trung', '2020-09-28 00:00:00', 'Kp Phú hòa', 'Đông Hòa', 'Nguyễn Chí Tâm', '0332526746', 'Phú Yên', '2020-09-28 11:10:18', 2),
(4, 0, 'Phường Hòa Hiệp Trung', '2020-09-28 00:00:00', 'KP', 'Đông Hòa', 'Nguyễn Thị Việt Dung', '03325267461', 'Phú Yên', '2020-09-28 11:10:11', 2),
(5, 0, 'Phường  Hòa Hiệp Trung', '2020-09-28 11:38:21', 'kp abcc', 'Đông Hòa', 'Nguyễn Thị Việt Dung', '0332526746', 'Phú Yên', '2020-09-28 11:47:21', 2),
(6, 1, 'Phường Hòa Hiệp Trung79', '2020-09-28 11:38:36', 'kkhjhh', 'Huyện Đông Hòa7', 'Tam', '0332526746', 'Phú Yên', '2020-09-28 11:38:36', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `auth`
--

CREATE TABLE `auth` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `permission` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `auth`
--

INSERT INTO `auth` (`id`, `activeFlag`, `createDate`, `updateDate`, `menu_id`, `role_id`, `permission`) VALUES
(1, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 1, 1, 1),
(2, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 2, 1, 1),
(3, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 3, 1, 1),
(4, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 4, 1, 1),
(6, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 6, 1, 1),
(7, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 7, 1, 1),
(8, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 8, 1, 1),
(9, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 9, 1, 1),
(10, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 10, 1, 1),
(11, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 11, 1, 1),
(12, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 12, 1, 1),
(13, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 13, 1, 1),
(14, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 14, 1, 1),
(15, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 15, 1, 1),
(16, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 16, 1, 1),
(17, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 17, 1, 1),
(18, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 18, 1, 1),
(19, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 19, 1, 1),
(20, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 20, 1, 1),
(21, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 21, 1, 1),
(22, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 22, 1, 1),
(23, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 23, 1, 1),
(24, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 24, 1, 1),
(25, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 25, 1, 1),
(26, 1, '2020-09-03 08:23:15', '2020-09-03 08:23:15', 26, 1, 1),
(27, 1, '2020-09-03 08:23:15', '2020-09-03 08:23:15', 27, 1, 1),
(28, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 28, 1, 1),
(29, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 29, 1, 1),
(30, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 30, 1, 1),
(31, 1, '2020-09-22 00:00:00', '2020-09-22 00:00:00', 31, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `author`
--

INSERT INTO `author` (`id`, `activeFlag`, `createDate`, `description`, `email`, `name`, `updateDate`, `url`) VALUES
(1, 1, '2020-09-23 20:39:59', 'Nguyễn Thu Hương ', 'thuhuong@gmail.com', 'Nguyễn Thu Hương', '2020-09-23 20:39:59', ''),
(2, 1, '2020-09-23 20:42:29', '', 'sidat@gmail.com', 'Sĩ Đạt', '2020-09-23 20:44:26', ''),
(3, 0, '2020-09-23 20:42:29', '', 'sidat@gmail.com', 'Sĩ Đạt', '2020-09-23 20:44:23', ''),
(4, 1, '2020-09-23 21:59:13', '', 'nhieutacgia@gmail.com', 'Nhiều tác giả', '2020-09-23 21:59:13', ''),
(5, 1, '2020-09-24 09:28:39', 'Hồ Quang Hiếu', 'hoquanhieu@gmail.com', 'Hồ Quang Hiếu', '2020-09-24 09:28:39', ''),
(6, 1, '2020-09-24 09:30:54', '', 'StephenieMeyer@gmail.com', 'Stephenie Meyer', '2020-09-24 09:30:54', ''),
(7, 1, '2020-09-24 09:32:12', '', 'haivan@gmail.com', 'Tô Hải Vân', '2020-09-24 09:32:12', ''),
(8, 1, '2020-09-24 09:33:45', '', 'ngocthuan@gmail.com', 'Nguyễn Ngọc Thuần', '2020-09-24 09:33:45', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banner`
--

CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `idParent` int(11) NOT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderIndex` int(11) NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `activeFlag`, `code`, `createDate`, `idParent`, `imgUrl`, `name`, `orderIndex`, `updateDate`, `url`) VALUES
(1, 1, 'STV', '2020-09-22 08:23:15', 0, '/resources/upload/1600845867207_sach_tieng_viet.jpg', 'Sách Tiếng Việt', 0, '2020-09-23 14:27:17', 'sach-tieng-viet'),
(2, 1, 'STA', '2020-09-22 08:23:15', 0, '/resources/upload/1600845949570_sach_tieng_Anh.png', 'Sách Tiếng Anh', 0, '2020-09-23 14:25:49', 'sach-tieng-anh'),
(3, 1, 'SVH', '2020-09-22 08:23:15', 1, '/resources/upload/1600846028911_img117.u3059.d20170616.t100547.729023.jpg', 'Sách Văn Học', 0, '2020-09-23 14:27:08', 'sach-van-hoc'),
(5, 1, 'SKT', '2020-09-23 14:13:51', 1, '/resources/upload/1600845231516_toi-tai-gioi.jpg', 'Sách Kinh Tế', 0, '2020-09-23 14:13:51', 'sach-kinh-te'),
(6, 1, 'ARTPHOTOGRAPHY', '2020-09-24 01:22:17', 2, '/resources/upload/1600885337981_ART & PHOTOGRAPHY.jpg', 'ART & PHOTOGRAPHY', 0, '2020-09-24 01:22:17', 'art-&-photography'),
(7, 1, 'BiographiesMemoirs', '2020-09-24 01:23:50', 2, '/resources/upload/1600885430500_BiographiesMemoirs.jpg', 'Biographies & Memoirs', 0, '2020-09-24 01:23:50', 'biographies-&-memoirs'),
(8, 1, 'BusinessEconomics', '2020-09-24 01:24:37', 2, '/resources/upload/1600885477126_BusinessEconomics.jpg', 'Business & Economics', 0, '2020-09-24 01:24:37', 'business-&-economics'),
(9, 1, 'HowtoSelfHelp', '2020-09-24 01:25:21', 2, '/resources/upload/1600885521546_HowtoSelfHelp.jpg', 'How-to - Self Help', 0, '2020-09-24 01:25:21', 'how-to---self-help'),
(10, 1, 'ChildrenBooks', '2020-09-24 01:26:31', 2, '/resources/upload/1600885591279_ChildrensBooks.jpg', 'Children\'s Books', 0, '2020-09-24 01:26:31', 'children-books'),
(11, 1, 'Dictionary', '2020-09-24 01:27:08', 2, '/resources/upload/1600885628328_Dictionary.jpg', 'Dictionary', 0, '2020-09-24 01:27:08', 'dictionary'),
(12, 1, 'AnhEducationTeaching', '2020-09-24 01:28:04', 2, '/resources/upload/1600885684128_AnhEducationTeaching.jpg', 'AnhEducation - Teaching', 0, '2020-09-24 01:28:04', 'anheducation---teaching'),
(13, 1, 'Magazines', '2020-09-24 01:30:22', 2, '/resources/upload/1600885822043_Magazines.jpg', 'Magazines', 0, '2020-09-24 01:30:22', 'magazines'),
(14, 1, 'FictionLiterature', '2020-09-24 01:30:53', 2, '/resources/upload/1600885853978_FictionLiterature.png', 'Fiction - Literature', 0, '2020-09-24 01:30:53', 'fiction---literature'),
(15, 1, 'MedicalBooks', '2020-09-24 01:31:21', 2, '/resources/upload/1600885881484_Medical Books.jpg', 'Medical Books', 0, '2020-09-24 01:31:21', 'medical-books');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `idParent` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orderIndex` int(11) NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `menu`
--

INSERT INTO `menu` (`id`, `activeFlag`, `createDate`, `idParent`, `name`, `orderIndex`, `updateDate`, `url`) VALUES
(1, 1, '2020-09-22 08:23:15', 0, 'Sản phẩm', 1, '2020-09-22 08:23:15', '/manage/product'),
(2, 1, '2020-09-22 08:23:15', 0, 'Đơn hàng', 2, '2020-09-22 08:23:15', '/manage/order'),
(3, 1, '2020-09-22 08:23:15', 0, 'Kho hàng', 3, '2020-09-22 08:23:15', '/manage/inventory'),
(4, 1, '2020-09-22 08:23:15', 0, 'Quản lý', 4, '2020-09-22 08:23:15', '/manage/manage'),
(6, 1, '2020-09-22 08:23:15', 0, 'Website', 5, '2020-09-22 08:23:15', '/manage/website'),
(7, 1, '2020-09-22 08:23:15', 1, 'Danh mục', 1, '2020-09-22 08:23:15', '/manage/category/list'),
(8, 1, '2020-09-22 08:23:15', 1, 'Sản phẩm', 2, '2020-09-22 08:23:15', '/manage/product-info/list'),
(9, 1, '2020-09-22 08:23:15', 1, 'Tác giả', 3, '2020-09-22 08:23:15', '/manage/author/list'),
(10, 1, '2020-09-22 08:23:15', 1, 'Nhà xuất bản', 4, '2020-09-22 08:23:15', '/manage/publisher/list'),
(11, 1, '2020-09-22 08:23:15', 1, 'Xóa', -1, '2020-09-22 08:23:15', '/manage/category/delete'),
(12, 1, '2020-09-22 08:23:15', 1, 'Sửa', -1, '2020-09-22 08:23:15', '/manage/category/edit'),
(13, 1, '2020-09-22 08:23:15', 1, 'Lưu', -1, '2020-09-22 08:23:15', '/manage/category/save'),
(14, 1, '2020-09-22 08:23:15', 1, 'Thêm', -1, '2020-09-22 08:23:15', '/manage/category/add'),
(15, 1, '2020-09-22 08:23:15', 1, 'Xóa', -1, '2020-09-22 08:23:15', '/manage/product-info/delete'),
(16, 1, '2020-09-22 08:23:15', 1, 'Sửa', -1, '2020-09-22 08:23:15', '/manage/product-info/edit'),
(17, 1, '2020-09-22 08:23:15', 1, 'Lưu', -1, '2020-09-22 08:23:15', '/manage/product-info/save'),
(18, 1, '2020-09-22 08:23:15', 1, 'Thêm', -1, '2020-09-22 08:23:15', '/manage/product-info/add'),
(19, 1, '2020-09-22 08:23:15', 1, 'Xóa', -1, '2020-09-22 08:23:15', '/manage/author/delete'),
(20, 1, '2020-09-22 08:23:15', 1, 'Sửa', -1, '2020-09-22 08:23:15', '/manage/author/edit'),
(21, 1, '2020-09-22 08:23:15', 1, 'Lưu', -1, '2020-09-22 08:23:15', '/manage/author/save'),
(22, 1, '2020-09-22 08:23:15', 1, 'Thêm', -1, '2020-09-22 08:23:15', '/manage/author/add'),
(23, 1, '2020-09-22 08:23:15', 1, 'Xóa', -1, '2020-09-22 08:23:15', '/manage/publisher/delete'),
(24, 1, '2020-09-22 08:23:15', 1, 'Sửa', -1, '2020-09-22 08:23:15', '/manage/publisher/edit'),
(25, 1, '2020-09-22 08:23:15', 1, 'Lưu', -1, '2020-09-22 08:23:15', '/manage/publisher/save'),
(26, 1, '2020-09-22 08:23:15', 1, 'Thêm', -1, '2020-09-22 08:23:15', '/manage/publisher/add'),
(27, 1, '2020-09-22 00:00:00', 2, 'Quản lý đơn hàng', 1, '2020-09-22 00:00:00', '/manage/order/list'),
(28, 1, '2020-09-22 00:00:00', 1, 'Xem', -1, '2020-09-22 00:00:00', '/manage/category/view'),
(29, 1, '2020-09-22 00:00:00', 1, 'Xem', -1, '2020-09-22 00:00:00', '/manage/product-info/view'),
(30, 1, '2020-09-22 00:00:00', 1, 'Xem', -1, '2020-09-22 00:00:00', '/manage/author/view'),
(31, 1, '2020-09-22 00:00:00', 1, 'Xem', -1, '2020-09-22 00:00:00', '/manage/publisher/view');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetail`
--

CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `totalPrice` decimal(19,2) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `productInfo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `orderdetail`
--

INSERT INTO `orderdetail` (`id`, `activeFlag`, `createDate`, `price`, `quantity`, `status`, `totalPrice`, `updateDate`, `order_id`, `productInfo_id`) VALUES
(1, 1, '2020-09-28 21:02:12', '1250000.00', 3, 0, '3750000.00', '2020-09-28 21:02:12', 2, 7),
(2, 1, '2020-09-28 21:02:12', '123000.00', 3, 0, '369000.00', '2020-09-28 21:02:12', 2, 8),
(3, 1, '2020-09-28 21:37:24', '123000.00', 5, 0, '615000.00', '2020-09-28 21:37:24', 3, 8),
(4, 1, '2020-09-28 21:37:24', '130000.00', 4, 0, '520000.00', '2020-09-28 21:37:24', 3, 9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `sales` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `subTotal` decimal(19,2) DEFAULT NULL,
  `totalPrice` decimal(19,2) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `vat` int(11) NOT NULL,
  `shipment_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `activeFlag`, `createDate`, `sales`, `status`, `subTotal`, `totalPrice`, `updateDate`, `vat`, `shipment_id`, `user_id`) VALUES
(2, 1, '2020-09-25 21:02:11', 0, 3, '4119000.00', '4119000.00', '2020-09-28 21:02:11', 0, 1, 2),
(3, 1, '2020-09-28 21:37:24', 0, 3, '1135000.00', '1135000.00', '2020-09-28 21:37:24', 0, 2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `productinfo`
--

CREATE TABLE `productinfo` (
  `id` int(11) NOT NULL,
  `ISBN` varchar(255) DEFAULT NULL,
  `activeFlag` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `dateOfPublication` datetime DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pageNumber` int(11) NOT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `size` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `url` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `productinfo`
--

INSERT INTO `productinfo` (`id`, `ISBN`, `activeFlag`, `code`, `createDate`, `dateOfPublication`, `description`, `imgUrl`, `name`, `pageNumber`, `price`, `size`, `status`, `updateDate`, `author_id`, `category_id`, `publisher_id`, `url`) VALUES
(3, '1647939179828', 1, 'combo-sach-10-loai-hinh-doi-moi', '2020-09-23 22:26:58', NULL, 'Giới thiệu Combo Sách : 10 Loại Hình Đổi Mới Sáng Tạo + Tư Duy Amazon\r\n10 Loại Hình Đổi Mới Sáng Tạo\r\n\r\nHầu hết các nhà khoa học đều đồng ý rằng chúng ta đang sống trong kỷ nguyên vĩ đại bậc nhất của sự thay đổi lịch sử loài người. Và tốc độ thay đổi cũng', '/resources/upload/1600874818669_combo10sach.jpg', 'Tuyển Tập Ca Khúc Về Mùa Xuân - Cánh Thiệp Đầu Xuân', 0, '125000.00', '0', 1, '2020-09-23 22:26:58', 4, 5, 2, 'tuyen-tap-ca-khuc-ve-mua-xuan---canh-thiep-dau-xuan'),
(4, '5153258197994', 1, 'combo-nguoi-giau-co-nhat-thanh-', '2020-09-23 00:00:00', '2020-09-21 00:00:00', 'Đây là 2 quyển sách mách bí quyết để bạn trở nên giàu có, sẽ “dẫn dắt bạn đi từ một hoàn cảnh khó khăn,', '/resources/upload/1600876228594_combo_nguoigiaunhat.jpg', 'Combo: Người giàu có nhất thành Babylon, Nghĩ giàu và làm giàu', 0, '170066.00', '0', 1, '2020-09-23 23:26:26', 4, 5, 2, 'combo:-nguoi-giau-co-nhat-thanh-babylon,-nghi-giau-va-lam-giau'),
(5, '9210553861961', 1, 'combo-3-cuon-thinh-vuong-tai-', '2020-09-24 00:00:00', NULL, 'Giới thiệu Combo 3 cuốn thinh vượng tài chính tuổi 30 và 7 chiến lược thịnh vượng và hạnh phúc tặng cuốn rèn luyện kĩ năng cho bé\r\nMột trong số những mong muốn chung của mọi người là việc sống mà không cần phải lo lắng về tiền. Dù gì đi nữa nếu thiếu tiền hoặc không có tiền thì sẽ có nhiều khi phiền não, đôi khi sẽ trở nên khốn khổ. Nếu trong cuộc sống nhất thiết phải lựa chọn thời kỳ không có tiền thì nên chọn khi nào?\r\n', '/resources/upload/1600890215299_combo-3-cuon-thinh-vuong-tai.jpg', 'Combo 3 cuốn thinh vượng tài chính tuổi 30 và 7 chiến lược thịnh', 0, '1250000.00', '0', 1, '2020-09-24 02:56:08', 4, 5, 2, 'combo-3-cuon-thinh-vuong-tai-chinh-tuoi-30-va-7-chien-luoc-thinh'),
(6, '4127981129271', 1, 'doi-thay', '2020-09-24 09:30:24', NULL, 'Giới thiệu Đổi Thay\r\nĐổi thay không đơn thuần là tựa của một cuốn sách. Đó thực sự là từ để chỉ chặng đường của Hồ Đổi thay gồm 4 phần kể về hành trình của cậu thanh niên Hồ Quang Hiếu từ khi nông nổi, bồng bột đến khi trở thành ca sĩ, học cách làm người tử tế. Thời nông nổi:\r\n\r\nSống mà không biết sống.\r\n\r\nHoàn lương: Đi tìm con đường đi của riêng mình, học cách sống tử tế, học cách làm người tử tế.\r\n', '/resources/upload/1600914624624_doi-thay.jpg', 'Đổi Thay', 0, '123000.00', '0', 1, '2020-09-24 09:30:24', 5, 3, 2, 'doi-thay'),
(7, '4501296610714', 1, 'sinh-tu-chang-vang', '2020-09-24 09:31:46', NULL, 'Giới thiệu Sinh Tử (Chạng Vạng Mới)\r\nSinh Tử (Chạng Vạng Mới)\r\n\r\nKhi Beaufort Swan chuyển đến sống ở thị trấn Forks ảm đạm và gặp Edythe Cullen bí ẩn, quyến rũ, cuộc đời anh ngoặt sang một trang khác thật hồi hộp và rùng rợn. Với làn da trắng như sứ, đôi mắt vàng như mật, giọng nói du dương và các năng lực siêu nhiên, Edythe vừa mê hoặc vừa khó lường.', '/resources/upload/1600914706891_sinh-tu-chang-vang.jpg', 'Sinh Tử (Chạng Vạng Mới)', 0, '1250000.00', '0', 1, '2020-09-24 09:31:46', 6, 3, 2, 'sinh-tu-(chang-vang-moi)'),
(8, '7673876365073', 1, 'khoi-dau-la-meo', '2020-09-24 09:33:16', NULL, 'Khởi Đầu Là Mèo\r\n\r\nCâu chuyện xoay quanh một thanh niên tên C, biệt hiệu 1701 do lão V đặt.\r\n\r\nVốn là người nhân hậu và bình thường như bao người khác, C đột nhiên bị lây nhiễm tính cách, đầu tiên là lây nhiễm tính cách mèo, anh ta đầy những đặc tính mèo. Sau đó anh ta lại bị lây nhiễm hành vi ăn cắp và côn đồ, lấy cắp nhanh như cắt và lúc nào cũng muốn đánh nhau. Dường như C trở nên một người khác.', '/resources/upload/1600914796156_khoi-dau-la-meo.jpg', 'Khởi Đầu Là Mèo', 0, '123000.00', '0', 1, '2020-09-24 09:33:16', 7, 3, 2, 'khoi-dau-la-meo'),
(9, '2742191927060', 1, 'tinh-yeu-phu-phiem', '2020-09-24 09:38:00', NULL, 'Trở về sau cái chết của người bố, Răng Nhọn - một nhà văn cô đơn và mẫn cảm đã phát hiện một nửa con người mình dần biến mất, đó là lúc anh bước vào phần thứ hai của cuộc đời, cũng là phần thứ hai của cuốn sách anh viết. Sự mập mờ đầy thi vị giữa các nhân vật và tình huống, cũng như văn phong đẹp đẽ giàu hình tượng khiến cho \"Vì tình yêu phù phiếm\" có sức lôi cuốn mạnh mẽ với người đọc. Đây cũng là lần đầu tiên Nguyễn Ngọc Thuần ghi tên mình trong thể loại tiểu thuyết...', '/resources/upload/1600915080168_tinh-yeu-phu-phiem.jpg', 'Vì Tình Yêu Phù Phiếm', 0, '130000.00', '0', 1, '2020-09-24 09:38:00', 8, 3, 1, 'vi-tinh-yeu-phu-phiem');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `publisher`
--

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `webiste` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `publisher`
--

INSERT INTO `publisher` (`id`, `activeFlag`, `address`, `code`, `createDate`, `email`, `name`, `phone`, `updateDate`, `webiste`, `url`) VALUES
(1, 1, 'Địa chỉ: 55 Quang Trung, Nguyễn Du, Hai Bà Trưng, Hà Nội', 'nxbkimdong', '2020-09-23 20:45:19', 'info@nxbkimdong.com.vn', 'Nhà xuất bản Kim Đồng', '0243 943 4490', '2020-09-23 20:45:53', 'https://nxbkimdong.com.vn/', ''),
(2, 1, '64 Bà Triệu, Hoàn Kiếm, Hà Nội', 'nxbThanhNien', '2020-09-23 20:46:50', '', 'NHÀ XUẤT BẢN THANH NIÊN', '098 25 26 569', '2020-09-23 20:47:35', 'https://www.nhaxuatbanthanhnien.vn/pages/frontpage', ''),
(3, 1, 'QL29, Hoà Phong, Tây Hòa, Phú Yên', 'nxbXuantien', '2020-09-23 21:57:52', '', 'nhà xuất bản xuân tiến', '098 326 41 26', '2020-09-23 21:57:52', '', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reviews`
--

CREATE TABLE `reviews` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `updateDate` datetime DEFAULT NULL,
  `productInfo_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`id`, `activeFlag`, `createDate`, `description`, `name`, `updateDate`) VALUES
(1, 1, '2020-09-22 00:00:00', 'role admin', 'ROLE_ADMIN', '2020-09-22 00:00:00'),
(2, 1, '2020-09-22 00:00:00', 'role staff', 'ROLE_STAFF', '2020-09-22 00:00:00'),
(3, 1, '2020-09-03 08:23:15', 'Role User', 'ROLE_USER', '2020-09-03 08:23:15');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shipmentdetails`
--

CREATE TABLE `shipmentdetails` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `commune` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `shipmentdetails`
--

INSERT INTO `shipmentdetails` (`id`, `activeFlag`, `commune`, `createDate`, `description`, `district`, `name`, `phone`, `province`, `updateDate`, `user_id`) VALUES
(1, 1, 'Phường Hòa Hiệp Trung', '2020-09-28 21:02:12', 'Kp Phú hòa', 'Đông Hòa', 'Nguyễn Chí Tâm', '0332526746', 'Phú Yên', '2020-09-28 21:02:12', 2),
(2, 1, 'Phường Hòa Hiệp Trung', '2020-09-28 21:37:24', 'Kp Phú hòa', 'Đông Hòa', 'Nguyễn Chí Tâm', '0332526746', 'Phú Yên', '2020-09-28 21:37:24', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `userrole`
--

CREATE TABLE `userrole` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `userrole`
--

INSERT INTO `userrole` (`id`, `activeFlag`, `createDate`, `updateDate`, `role_id`, `user_id`) VALUES
(1, 1, '2020-09-03 08:23:15', '2020-09-27 21:23:26', 1, 1),
(2, 1, '2020-09-26 16:15:03', '2020-09-27 23:00:16', 3, 2),
(5, 1, '2020-09-26 16:37:29', '2020-09-28 00:27:32', 3, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `birthDay` datetime DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `activeFlag`, `birthDay`, `createDate`, `email`, `name`, `password`, `phone`, `updateDate`, `username`) VALUES
(1, 1, '1999-09-22 00:00:00', '2020-09-27 21:23:26', 'xomrayno5@gmail.com', 'Nguyễn Tâm', '12345', '0133333', '2020-09-27 21:23:26', 'admin'),
(2, 1, '2020-09-23 00:00:00', '2020-09-27 23:07:39', 'xomrayno1@gmail.com', 'Nguyễn Tâm', '12345', '01323232', '2020-09-27 23:07:39', 'xomrayno1'),
(5, 1, '2020-09-23 00:00:00', '2020-09-28 00:27:32', 'xomrayno2@gmail.com', 'Nguyễn Chí Tâm', '12345', '0332526746', '2020-09-28 00:27:32', 'xomrayno2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `wishlist`
--

CREATE TABLE `wishlist` (
  `id` int(11) NOT NULL,
  `activeFlag` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `productInfo_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `wishlist`
--

INSERT INTO `wishlist` (`id`, `activeFlag`, `createDate`, `updateDate`, `productInfo_id`, `user_id`) VALUES
(1, 1, '2020-09-26 22:15:16', '2020-09-26 22:15:16', 6, 1),
(2, 1, '2020-09-26 23:23:34', '2020-09-26 23:23:34', 7, 1),
(3, 1, '2020-09-26 23:24:01', '2020-09-26 23:24:01', 9, 1),
(4, 1, '2020-09-26 23:24:06', '2020-09-26 23:24:06', 8, 1),
(5, 1, '2020-09-26 23:24:11', '2020-09-26 23:24:11', 5, 1),
(6, 1, '2020-09-26 23:24:15', '2020-09-26 23:24:15', 3, 1),
(7, 0, '2020-09-27 01:41:02', '2020-09-27 21:51:02', 7, 1),
(11, 0, '2020-09-27 21:47:47', '2020-09-27 21:54:59', 7, 2),
(13, 0, '2020-09-27 21:51:18', '2020-09-27 21:54:57', 9, 2),
(14, 0, '2020-09-27 21:55:11', '2020-09-27 21:55:14', 6, 2),
(15, 0, '2020-09-27 21:55:18', '2020-09-28 00:50:17', 6, 2),
(16, 1, '2020-09-27 21:55:21', '2020-09-27 21:55:21', 7, 2),
(17, 0, '2020-09-27 21:55:23', '2020-09-28 00:50:18', 8, 2),
(18, 0, '2020-09-27 21:55:25', '2020-09-28 11:10:28', 9, 2),
(19, 0, '2020-09-27 21:55:35', '2020-09-27 21:55:42', 3, 2),
(20, 0, '2020-09-27 21:55:37', '2020-09-27 21:55:44', 4, 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfmbstuufapi4tvs7epqq1q0pq` (`user_id`);

--
-- Chỉ mục cho bảng `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3r30mkdo6hpqatfij7oo7oh6l` (`role_id`),
  ADD KEY `FKfum0d6jnhosfl6y9k41ve6n9g` (`menu_id`);

--
-- Chỉ mục cho bảng `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKji4p042ka7if8knsq34l1hjvt` (`order_id`),
  ADD KEY `FKna3fxjv1ie9q3bfl9l3nte2mf` (`productInfo_id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjc9jise41275svbb1kbdfojj4` (`shipment_id`),
  ADD KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`);

--
-- Chỉ mục cho bảng `productinfo`
--
ALTER TABLE `productinfo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe9mykxsf7g3x2ngs51xb5r9i5` (`author_id`),
  ADD KEY `FKk1r3t9ythypcyk0nn77g638al` (`publisher_id`),
  ADD KEY `FKs8etagnke1q538hhw3jaosb8l` (`category_id`);

--
-- Chỉ mục cho bảng `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr7dcndtlfhj9o0dwt6iev3blg` (`user_id`),
  ADD KEY `FKeuhx84y85pi8b0gnexefh801n` (`productInfo_id`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `shipmentdetails`
--
ALTER TABLE `shipmentdetails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK79x8xdplsn7ew6d337yl7bq8k` (`user_id`);

--
-- Chỉ mục cho bảng `userrole`
--
ALTER TABLE `userrole`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5s6hpno3nsvs1pv3t1ai4gqyh` (`role_id`),
  ADD KEY `FK9oq5pok13ocqcbxcrqh21bg43` (`user_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK90cj5paybvhe5f5810r22q2ya` (`productInfo_id`),
  ADD KEY `FK9w6xg7o290mc21jg9ivk3shyt` (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `auth`
--
ALTER TABLE `auth`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `banner`
--
ALTER TABLE `banner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `productinfo`
--
ALTER TABLE `productinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `publisher`
--
ALTER TABLE `publisher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `shipmentdetails`
--
ALTER TABLE `shipmentdetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `userrole`
--
ALTER TABLE `userrole`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `FKfmbstuufapi4tvs7epqq1q0pq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `auth`
--
ALTER TABLE `auth`
  ADD CONSTRAINT `FK3r30mkdo6hpqatfij7oo7oh6l` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKfum0d6jnhosfl6y9k41ve6n9g` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`);

--
-- Các ràng buộc cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `FKji4p042ka7if8knsq34l1hjvt` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `FKna3fxjv1ie9q3bfl9l3nte2mf` FOREIGN KEY (`productInfo_id`) REFERENCES `productinfo` (`id`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKjc9jise41275svbb1kbdfojj4` FOREIGN KEY (`shipment_id`) REFERENCES `shipmentdetails` (`id`);

--
-- Các ràng buộc cho bảng `productinfo`
--
ALTER TABLE `productinfo`
  ADD CONSTRAINT `FKe9mykxsf7g3x2ngs51xb5r9i5` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  ADD CONSTRAINT `FKk1r3t9ythypcyk0nn77g638al` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`),
  ADD CONSTRAINT `FKs8etagnke1q538hhw3jaosb8l` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FKeuhx84y85pi8b0gnexefh801n` FOREIGN KEY (`productInfo_id`) REFERENCES `productinfo` (`id`),
  ADD CONSTRAINT `FKr7dcndtlfhj9o0dwt6iev3blg` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `shipmentdetails`
--
ALTER TABLE `shipmentdetails`
  ADD CONSTRAINT `FK79x8xdplsn7ew6d337yl7bq8k` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `userrole`
--
ALTER TABLE `userrole`
  ADD CONSTRAINT `FK5s6hpno3nsvs1pv3t1ai4gqyh` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FK9oq5pok13ocqcbxcrqh21bg43` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `wishlist`
--
ALTER TABLE `wishlist`
  ADD CONSTRAINT `FK90cj5paybvhe5f5810r22q2ya` FOREIGN KEY (`productInfo_id`) REFERENCES `productinfo` (`id`),
  ADD CONSTRAINT `FK9w6xg7o290mc21jg9ivk3shyt` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
