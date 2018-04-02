CREATE TABLE t_member
(
    m_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    m_name VARCHAR(60) NOT NULL,
    m_phone VARCHAR(30) NOT NULL,
    m_level INT NOT NULL,
    m_in_time DATE NOT NULL,
    m_card_no VARCHAR(10) NOT NULL UNIQUE
);
CREATE UNIQUE INDEX t_member_m_card_no_uindex ON t_member (m_card_no);