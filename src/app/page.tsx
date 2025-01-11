import Image from "next/image";

export default function Home() {
  return (
    <div className="bg-gray-900">
      <main className="flex items-center justify-center min-h-screen">
        <div className="flex flex-col text-center items-center">
          <Image
            src={"/prtcg_logo.png"}
            alt="professorsresearchtcg.com main logo"
            width={250}
            height={250}
          />
          <h1>coming soon...</h1>
          <p>
            In the meantime, please checkout{" "}
            <a
              href="https://ptcgpocket.net"
              className="underline text-blue-500"
            >
              ptcgpocket.net
            </a>
          </p>
        </div>
      </main>
    </div>
  );
}
